package com.example.wordsapp

import androidx.fragment.app.Fragment

class WordListFragment : Fragment() {
//  Menyalin objek pendamping dari DetailActivity.kt ke WordListFragment.kt
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
//  menambahkan variabel binding jenis FragmentWordListBinding?
    private var _binding: FragmentWordListBinding? = null
//  membuat variabel hanya-dapatkan sehingga Anda dapat mereferensikan
//  tampilan tanpa harus menggunakan '?'
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(activity?.intent?.extras?.getString(LETTER).toString(), requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }
//  Menyetel ulang variabel _binding di onDestroyView()
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}