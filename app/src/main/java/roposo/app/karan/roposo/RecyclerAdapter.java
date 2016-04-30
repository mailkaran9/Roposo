package roposo.app.karan.roposo;

/**
 * Created by DELL on 4/29/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by rajat on 2/8/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] id;
    private String[] username;
    private String[] si;
    private String[] db;
    private String[] title;
    private String[] description;
    public RecyclerAdapter(String[] titles, String[] descriptions, String[] sis, String[] ids, String[] dbs, String[] usernames){

        id=ids;
        username=usernames;
        si=sis;
        title=titles;
        description=descriptions;
        db=dbs;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader imageLoader = MainActivity.getImageLoader();

        holder.textView1.setText(title[position]);
        holder.textView2.setText(description[position]);
        holder.textView3.setText(username[position]);
        holder.iv.setImageUrl(si[position],imageLoader);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView textView1;
        protected TextView textView2;
        protected TextView textView3;
        NetworkImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);

            textView1 =  (TextView) itemView.findViewById(R.id.textViewId);
            textView2 =  (TextView) itemView.findViewById(R.id.textViewName);
            iv= (NetworkImageView)itemView.findViewById(R.id.iv);
            textView3 =  (TextView) itemView.findViewById(R.id.author);
        }


    }
}