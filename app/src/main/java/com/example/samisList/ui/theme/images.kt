
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel(images: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000)
            coroutineScope.launch {
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % pagerState.pageCount)
            }
        }
    }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp) // Add horizontal padding for the entire Column
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(4.dp) // Add padding around the pager for shadow effect
        ) { page ->
            Card(
                modifier = Modifier
                    .aspectRatio(4f / 2f) // Keep the aspect ratio of the card
                    .fillMaxWidth(0.8f) // Fill only 80% of the width
                    .padding(4.dp), // Add padding around the card for space between pages
                elevation = 4.dp
            ) {
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Image carousel item",
                    contentScale = ContentScale.Crop // Crop the image if necessary to fill the bounds
                )
            }
        }
    }
}


//
//@Composable
//fun ImageCarousel(images: List<Int>) {
//    val pagerState = rememberPagerState(pageCount = { images.size })
//    val coroutineScope = rememberCoroutineScope()
//
//    LaunchedEffect(pagerState) {
//        while (true) {
//            delay(3000)
//            coroutineScope.launch {
//                pagerState.animateScrollToPage((pagerState.currentPage + 1) % pagerState.pageCount)
//            }
//        }
//    }
//    Column(
//    ) {
//
//            HorizontalPager(
//                state = pagerState,
//            ) { page ->
//                Card(
//                    modifier = Modifier
//                        .aspectRatio(4f / 3.0f)
//                        .fillMaxWidth(),
//                    elevation = 4.dp
//                ) {
//                    Image(
//                        modifier = Modifier.fillMaxSize(),
//                        painter = painterResource(id = images[page]),
//                        contentDescription = "Image carousel item"
//                    )
//                }
//            }}
//}

@Composable
@Preview
fun ImageCarouselPreview() {
    val placeholderImages = listOf(
        R.drawable.bruschetta, R.drawable.greeksalad, R.drawable.most_liked
    )
    ImageCarousel(placeholderImages)
}