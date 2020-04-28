package com.gabutproject.triviaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        if (args != null) {
            Toast.makeText(context, "question answered ${args.numCorrects}", Toast.LENGTH_LONG)
                .show()
        }

        return binding.root
    }
}