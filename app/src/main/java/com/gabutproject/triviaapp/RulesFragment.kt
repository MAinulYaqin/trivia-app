package com.gabutproject.triviaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gabutproject.triviaapp.databinding.RulesFragmentBinding

class RulesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RulesFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.rules_fragment, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.rules)

        return binding.root
    }
}