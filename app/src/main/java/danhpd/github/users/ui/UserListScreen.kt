package danhpd.github.users.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import danhpd.github.users.data.models.User
import danhpd.github.users.data.repository.UserRepositoryImpl
import danhpd.github.users.domain.Status
import danhpd.github.users.domain.UserListViewModel

@Composable
//init UserListViewModel and UserRepositoryImpl when screen start
fun UserListScreen(model: UserListViewModel = UserListViewModel(UserRepositoryImpl())) {
    MaterialTheme {
        //show loading indicator while processing
        if (model.uiState.status.value == Status.PROCESSING) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }
        //list of users
        LazyColumn (Modifier.fillMaxWidth()) {
            items(model.uiState.users) { user ->
                UserCard(user, model)
            }
        }
    }
}

@Composable
fun UserCard(user: User, model: UserListViewModel) {
    Card(
        modifier = Modifier
            .clickable {
                Log.d("tagg", "click UserCard: ")
                //model.loadUsers()
            }
            .padding(all = 4.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ){
        // Add padding around card
        Row(modifier = Modifier.padding(all = 15.dp)) {
            //Avatar
            Image(
                painter = rememberImagePainter(
                    data = user.avatar_url,
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(
                        CircleShape
                    )
            )
            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                //username
                Text(
                    text = user.login,
                    color = Color.Gray,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                //staff badge
                if (user.site_admin){
                    Text(
                        color = Color.White,
                        text = "STAFF",
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(color = Color.Blue, shape = RoundedCornerShape(15.dp))
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }
            }
        }
    }

}