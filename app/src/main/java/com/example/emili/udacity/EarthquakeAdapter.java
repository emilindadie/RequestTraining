package com.example.emili.udacity;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Created by emili on 12/07/2017.
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Earthquake> data;
    Context context;
    LayoutInflater layoutInflater;
    int taille;
    public EarthquakeAdapter(Context context, List<Earthquake> data){
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.earthquake, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        Earthquake earthquake = data.get(position);
        String formatMagnitude = formatMagnitude(earthquake.getMagnitude());
        myHolder.magnitude.setText(String.valueOf(earthquake.getMagnitude()));
        myHolder.magnitude.setText(formatMagnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) myHolder.magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        String location = earthquake.getLocation();
       String[] parts = location.split("of");
       //String of = " of";
        String part1 = parts[0];
        String part2 = parts[1];
        myHolder.locationP1.setText(part1);
        myHolder.locationP2.setText(part2);
        Date object = new Date(earthquake.getTime());
        String formatDate = formatDate(object);
        myHolder.time.setText(formatDate);
       String formatTime = formatTime(object);
        myHolder.date.setText(formatTime);
    }

    @Override
    public int getItemCount() {
        taille = data.size();
        return taille;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView magnitude;
        TextView locationP1;
        TextView locationP2;
        TextView time;
        TextView date;
        public MyHolder(View itemView) {
            super(itemView);

            magnitude = (TextView) itemView.findViewById(R.id.magnitude);
            locationP1 = (TextView) itemView.findViewById(R.id.locationP1);
            locationP2 = (TextView) itemView.findViewById(R.id.locationP2);
            time = (TextView) itemView.findViewById(R.id.time);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.FRANCE);
        return dateFormat.format(dateObject);
    }


    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.FRANCE);
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
         int magnitudeColorResourceId;
         int magnitudeFloor = (int) Math.floor(magnitude);
         switch (magnitudeFloor) {
               case 0:
               case 1:
                     magnitudeColorResourceId = R.color.magnitude1;
                     break;
               case 2:
                     magnitudeColorResourceId = R.color.magnitude2;
                     break;
               case 3:
                       magnitudeColorResourceId = R.color.magnitude3;
                     break;
               case 4:
                       magnitudeColorResourceId = R.color.magnitude4;
                        break;
               case 5:
                    magnitudeColorResourceId = R.color.magnitude5;
                       break;
               case 6:
                       magnitudeColorResourceId = R.color.magnitude6;
                        break;
               case 7:
                      magnitudeColorResourceId = R.color.magnitude7;
                      break;
               case 8:
                       magnitudeColorResourceId = R.color.magnitude8;
                     break;
               case 9:
                    magnitudeColorResourceId = R.color.magnitude9;
                        break;
               default:
                       magnitudeColorResourceId = R.color.magnitude10plus;
                       break;
         }

            return ContextCompat.getColor(context, magnitudeColorResourceId);

       }


}

