package my.edu.tarc.carloann

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import my.edu.tarc.carloann.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO 4: Create an instance of Data Binding
        /*_binding = FragmentSecondBinding.inflate(inflater, container, false)
        */
        _binding = DataBindingUtil.inflate(
            inflater,
                R.layout.fragment_second,
            container,
            false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO 5: Create an instance of data class
        val interestData = InterestData("CIMB\nMaybank\nPublic Bank\nHLB", "2.95(p.a)\n3.01(p.a)\n3.15(p.a)\n3.05(p.a)")

        //TODO 6: Link Data class to layout

        binding.bankInterestRate = interestData

        binding.buttonClose.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}