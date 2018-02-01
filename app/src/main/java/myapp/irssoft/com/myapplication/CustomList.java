package myapp.irssoft.com.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by dell on 01-02-2018.
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    public CustomList(Activity context,
                      String[] web) {
        super(context, R.layout.single_list, web);
        this.context = context;
        this.web = web;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);

        Glide.with(this.context).load("http://i.imgur.com/DvpvklR.png").apply(requestOptions).into(imageView);
        return rowView;
    }
}
