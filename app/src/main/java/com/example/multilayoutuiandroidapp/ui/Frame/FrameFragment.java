package com.example.multilayoutuiandroidapp.ui.Frame;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.multilayoutuiandroidapp.R;
import com.example.multilayoutuiandroidapp.databinding.FragmentFrameBinding;

public class FrameFragment extends Fragment {

    private FragmentFrameBinding binding;
    private ImageView profileImage;

    // Using ActivityResultLauncher instead of deprecated onActivityResult
    private final ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == android.app.Activity.RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    profileImage.setImageURI(imageUri);
                }
            });

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FrameViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FrameViewModel.class);

        binding = FragmentFrameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFrame;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        profileImage = binding.profileImage;
        Button editButton = binding.btnEditProfile;

        editButton.setOnClickListener(v -> openGallery());

        return root;
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
