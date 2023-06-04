package com.example.fragmentos;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragmentado extends Fragment {

    private VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_fragmentado, container, false);

        videoView = view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.video));
        videoView.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (videoView != null) {
            videoView.stopPlayback();
            videoView = null;
        }
    }
}


