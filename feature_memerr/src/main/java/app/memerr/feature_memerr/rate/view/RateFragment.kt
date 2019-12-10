package app.memerr.feature_memerr.rate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import app.memerr.feature_memerr.R
import app.memerr.feature_memerr.rate.adapter.CardStackAdapter
import app.memerr.feature_memerr.rate.di.component.RateComponent
import app.memerr.feature_memerr.rate.viewmodel.RateViewModel
import app.memerr.feature_memerr.shared.model.Meme
import com.yuyakaido.android.cardstackview.*
import javax.inject.Inject

class RateFragment : Fragment(), CardStackListener {

    companion object {
        fun newInstance() = RateFragment()
    }

    @Inject
    lateinit var factory: RateViewModel.RateViewModelFactory

    @Inject
    lateinit var adapter: CardStackAdapter

    private val viewModel: RateViewModel by viewModels { factory }
    private lateinit var cardStackView: CardStackView

    private lateinit var manager: CardStackLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RateComponent.component().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.rate_fragment, container, false)

        cardStackView = v.findViewById(R.id.cardStackView)
        initializeCardStackView()

        v.findViewById<View>(R.id.fabLike).setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }

        v.findViewById<View>(R.id.fabDislike).setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.memes.observe(this, Observer<PagedList<Meme>> { memes ->
            adapter.submitList(memes)

            cardStackView.scrollToPosition(viewModel.currentTop)
        })
    }

    private fun initializeCardStackView() {
        manager = CardStackLayoutManager(context, this)

        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
    }

    override fun onCardDisappeared(view: View, position: Int) {
        viewModel.lastInteractedWithIndex = position
    }

    override fun onCardDragging(direction: Direction, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction) {
        viewModel.cardSwiped(direction)
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View, position: Int) {
        viewModel.currentTop = position
    }

    override fun onCardRewound() {
    }

}
