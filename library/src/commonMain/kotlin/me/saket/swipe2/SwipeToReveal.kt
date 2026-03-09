package me.saket.swipe2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SwipeToReveal(
  state: SwipeToRevealState,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  content: @Composable SwipeToRevealScope.() -> Unit,
) {
  BasicSwipeToReveal(
    state = state,
    modifier = modifier,
    enabled = enabled,
    leadingActions = {
      Box(
        Modifier
          .fillMaxSize()
          .background(Color(0xFF008A36), CircleShape)
      )
    },
    trailingActions = {
      Box(
        Modifier
          .fillMaxSize()
          .background(Color(0xFFF9A825), CircleShape)
      )
    },
  ) {
    content(
      RealSwipeToRevealScope(this)
    )
  }
}

interface SwipeToRevealScope : BoxScope {
}

private class RealSwipeToRevealScope(
  private val boxScope: BoxScope,
) : SwipeToRevealScope, BoxScope by boxScope
