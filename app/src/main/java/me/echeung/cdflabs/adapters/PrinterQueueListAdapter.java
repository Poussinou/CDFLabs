package me.echeung.cdflabs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import me.echeung.cdflabs.R;
import me.echeung.cdflabs.holders.PrintJobHolder;
import me.echeung.cdflabs.printers.PrintJob;

public class PrinterQueueListAdapter extends ArrayAdapter<PrintJob> {

    public PrinterQueueListAdapter(Context context, int resId) {
        super(context, resId);
    }

    public View getView(int position, View itemView, ViewGroup parent) {
        if (itemView == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            itemView = vi.inflate(R.layout.queue_job_item, null);
        }

        final PrintJobHolder holder = new PrintJobHolder(itemView);
        final PrintJob job = getItem(position);

        if (job.hasError()) {
            holder.filesView.setText(
                    String.format(getContext().getString(R.string.queue_rank),
                            job.getRank()));
            holder.infoView.setText(job.getError());
        } else {
            holder.filesView.setText(
                    String.format(getContext().getString(R.string.queue_files),
                            job.getRank(), job.getSize()));
            holder.infoView.setText(
                    String.format(getContext().getString(R.string.queue_info),
                            job.getJob(), job.getTime()));
        }

        return itemView;
    }
}
