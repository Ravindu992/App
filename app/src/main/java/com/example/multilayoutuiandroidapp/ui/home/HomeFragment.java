package com.example.multilayoutuiandroidapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.multilayoutuiandroidapp.R;
import com.example.multilayoutuiandroidapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button btnViewProfile = root.findViewById(R.id.btnViewProfile);
        Button btnManageStudents = root.findViewById(R.id.btnManageStudents);

        btnViewProfile.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.navigation_Frame);
        });

        btnManageStudents.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.navigation_form);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}