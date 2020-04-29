package com.gabutproject.triviaapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.content.IntentCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gabutproject.triviaapp.databinding.GameWonFragmentBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameWonFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_won_fragment, container, false
        )
        binding.continueButton.setOnClickListener {
            it.findNavController()
                .navigate(GameWonFragmentDirections.actionGameWonFragmentToTitleFragment())
        }

        setHasOptionsMenu(true)

        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        if (args != null) {
            binding.result = getString(R.string.correct_answer, args.numCorrects, args.numQuestions)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)

        if (null == getShareIntent()?.resolveActivity(requireActivity().packageManager)) {
            menu?.findItem(R.id.share)?.isVisible = false
        }
    }

    private fun getShareIntent(): Intent? {
        var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }

        return activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(getString(R.string.correct_answer, args?.numCorrects, args?.numQuestions))
                .setType("text/plain")
                .intent
        }
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
}