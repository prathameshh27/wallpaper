package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.octet.qbit.wallpaper.Category;
import com.octet.qbit.wallpaper.R;
import com.octet.qbit.wallpaper.WallpaperActivity;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoriesAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_categories, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category c = categoryList.get(position);
        holder.textView.setText(c.name);
        Glide.with(context).load(c.thumb).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;
        public CategoryViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.cat_name);
            imageView = itemView.findViewById(R.id.imageview_cat);

        }

        @Override
        public void onClick(View v) {
            int p = getAdapterPosition();
            Category c = categoryList.get(p);
            Intent intent = new Intent(context, WallpaperActivity.class);
            intent.putExtra("category", c.name);
            context.startActivity(intent);
        }
    }
}
