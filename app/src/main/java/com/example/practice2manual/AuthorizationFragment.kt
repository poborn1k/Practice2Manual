package com.example.practice2manual

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practice2manual.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {
    lateinit var binding : FragmentAuthorizationBinding
    private val informationModel : InformationModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.logInButton.setOnClickListener {
            informationModel.email.value = binding.loginInput.text.toString()
            informationModel.username.value = "Рустам"
            informationModel.dateOfBirth.value = "24.02.04"

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainContentFragment())
                .addToBackStack(null).commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthorizationFragment()
    }
}