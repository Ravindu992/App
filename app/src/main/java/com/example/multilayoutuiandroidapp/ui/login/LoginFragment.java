package com.example.multilayoutuiandroidapp.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.multilayoutuiandroidapp.R;
import com.example.multilayoutuiandroidapp.data.DatabaseHelper;

public class LoginFragment extends Fragment {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private DatabaseHelper databaseHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        databaseHelper = new DatabaseHelper(requireContext());
        
        editTextUsername = root.findViewById(R.id.editTextUsername);
        editTextPassword = root.findViewById(R.id.editTextPassword);
        Button buttonLogin = root.findViewById(R.id.buttonLogin);
        Button buttonRegister = root.findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(v -> attemptLogin());
        buttonRegister.setOnClickListener(v -> attemptRegister());

        return root;
    }

    private void attemptLogin() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.checkUser(username, password)) {
            // Navigate to Home Fragment
            Navigation.findNavController(requireView()).navigate(R.id.navigation_home);
        } else {
            Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void attemptRegister() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        long result = databaseHelper.registerUser(username, password);
        if (result != -1) {
            Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT).show();
        }
    }
}
