package com.example.practice2manual

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.practice2manual.databinding.FragmentMainContentBinding

class MainContentFragment : Fragment() {
    lateinit var binding: FragmentMainContentBinding
    private val informationModel : InformationModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        informationModel.username.observe(activity as LifecycleOwner, {
            binding.nameTitle.text = "Имя - " + it
        })

        informationModel.email.observe(activity as LifecycleOwner, {
            binding.emailTitle.text = "Почта - " + it
        })

        informationModel.dateOfBirth.observe(activity as LifecycleOwner, {
            binding.dateOfBirthTitle.text = "Дата рождения - " + it
        })

        binding.changeDataButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ChangeDataFragment())
                .addToBackStack(null).commit()
        }

        binding.backToAuthorization.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AuthorizationFragment())
                .addToBackStack(null).commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainContentFragment()
    }
}