import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.pgd.harrypotter.coreui.components.HomeTabBarItem
import com.pgd.harrypotter.coreui.components.RecipeItem
import com.pgd.harrypotter.coreui.components.ReviewsSection
import com.pgd.harrypotter.coreui.components.ServingsItem
import com.pgd.harrypotter.coreui.components.ShoppingButton
import com.pgd.harrypotter.domain.model.Recipe
import kotlin.math.roundToInt

@Composable
fun HomeBody(
    recipe: Recipe,
    scrollState: ScrollState,
    toolbarOffsetHeightPx: Dp,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier
            .height(250.dp)
            .offset {
                IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt())
            })
        RecipeItem(recipe = recipe)
        ServingsItem(recipe = recipe)
        HomeTabBarItem(recipe = recipe)
        ShoppingButton()
        ReviewsSection()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(8.dp)
        ) {
            FloatingActionButton(
                onClick = { /* Handle button click */ },
                containerColor = Color(0xFFB21C55),
                elevation = FloatingActionButtonDefaults.elevation(2.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Text("Start Cooking", color = Color.White)
            }
        }

    }

}
