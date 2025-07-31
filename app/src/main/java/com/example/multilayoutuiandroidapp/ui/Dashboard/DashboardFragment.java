package com.example.multilayoutuiandroidapp.ui.Dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.multilayoutuiandroidapp.R;

public class DashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView dashboardTitle = root.findViewById(R.id.dashboardTitle);
        TextView notificationsText = root.findViewById(R.id.notificationsText);
        TextView accountStatusText = root.findViewById(R.id.accountStatusText);
        EditText searchBar = root.findViewById(R.id.searchBar);
        Button btnViewProfile = root.findViewById(R.id.btnViewProfile);
        Button btnSettings = root.findViewById(R.id.btnSettings);

        // Set click listeners for buttons
        btnViewProfile.setOnClickListener(v -> 
            Toast.makeText(requireContext(), "View Profile clicked", Toast.LENGTH_SHORT).show()
        );

        btnSettings.setOnClickListener(v -> 
            Toast.makeText(requireContext(), "Settings clicked", Toast.LENGTH_SHORT).show()
        );

        return root;
    }