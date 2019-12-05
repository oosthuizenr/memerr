package app.memerr.feature_memerr.disliked.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import app.memerr.feature_memerr.R
import app.memerr.feature_memerr.disliked.viewmodel.DislikedViewModel

class DislikedFragment : Fragment() {

    companion object {
        fun newInstance() = DislikedFragment()
    }

    private lateinit var viewModel: DislikedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.disliked_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DislikedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
