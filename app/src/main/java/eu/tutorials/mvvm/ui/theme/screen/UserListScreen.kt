import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.mvvm.ui.theme.components.UserItem
import eu.tutorials.mvvm.viewmodel.UserUiState
import eu.tutorials.mvvm.viewmodel.UserViewModel


@Composable
fun UserListScreen(
    viewModel: UserViewModel = viewModel()
){
    val state by viewModel.uiState.collectAsState()
    when(state){
        //Loading
        is UserUiState.Loading ->{
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        //Success
        is UserUiState.Success ->{
            val users = (state as UserUiState.Success).users

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp)

            ) {
                items(users){
                    user ->
                    UserItem(user = user)
                }
            }
        }

        //Error
        is UserUiState.Error -> {
            val message = (state as UserUiState.Error).message
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {viewModel.fetchUsers()}){
                    Text("Tekrar Dene")
                }
            }
        }
    }

}