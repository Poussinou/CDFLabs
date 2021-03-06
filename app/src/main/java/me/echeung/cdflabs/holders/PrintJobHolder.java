package me.echeung.cdflabs.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.echeung.cdflabs.R;

public class PrintJobHolder extends RecyclerView.ViewHolder {

    public TextView filesView;
    public TextView infoView;

    public PrintJobHolder(View itemView) {
        super(itemView);

        filesView = (TextView) itemView.findViewById(R.id.print_job_files);
        infoView = (TextView) itemView.findViewById(R.id.print_job_info);
    }
}