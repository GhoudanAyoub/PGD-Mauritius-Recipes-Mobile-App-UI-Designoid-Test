import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.pgd.harrypotter.coreui.components.HomeTabBarItem
import com.pgd.harrypotter.coreui.components.RecipeItem
import com.pgd.harrypotter.coreui.components.ServingsItem
import com.pgd.harrypotter.coreui.components.ShoppingButton
import com.pgd.harrypotter.domain.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBody(
    recipe: Recipe,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState()),  // Add vertical scroll,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { RecipeItem(recipe = recipe) }
            item { ServingsItem(recipe = recipe) }
            item { HomeTabBarItem(recipe = recipe) }
            item { ShoppingButton() }
        }
    }
//    }
}
