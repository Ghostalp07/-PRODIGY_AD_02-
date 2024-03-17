package com.example.TODO.ui.theme.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import com.example.todo.data.TODO

@Composable
fun TODOItem(
    todo: TODO, // Changed parameter name to 'todo' for consistency
    onChecked: (Boolean) -> Unit,
    onDelete: (TODO) -> Unit,
    onNavigation: (TODO) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onNavigation(todo) },
        shape = RoundedCornerShape(8.dp),
    colors =Color.Blue ,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Checkbox(
                checked = todo.isComplete,
                onCheckedChange = { onChecked(it) },
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                /*     Text(
                       text = todo.todo,
                       style = MaterialTheme.typography.bodyMedium
                   )
                   Spacer(modifier = Modifier.height(16.dp))
                   CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                           text = todo.time,
                           style = MaterialTheme.typography.bodyMedium// Use body2 or another appropriate style
                       )*/
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { onDelete(todo) }) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
    }

