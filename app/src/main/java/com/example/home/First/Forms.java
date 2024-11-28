package com.example.home.First;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
public class Forms  {
  private   Context context;
  private   int Width;
 private    int Height;
 private    Class view;
  private   UniversalAdapter universalAdapter;
  private   LinearLayout layout;

    public List<View> getViewList() {
        return viewList;
    }

    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }

    private   List<View> viewList;
public Forms(Context context, int Width, int Height, Class view) {
    this.context = context;
    this.Width = Width;
    this.Height = Height;
    this.view = view;
    layout = new LinearLayout(context);
    initView();
}
  public View getView(int position) {
    return universalAdapter.getItem(position);
  }
  public LinearLayout getLayout() {
    return layout;
  }
  public void addLayoutTop(LinearLayout ll) {

      layout.addView(ll, 0);
  }
  public void addLayoutBottom(LinearLayout layout) {
      layout.addView(layout);
  }
  public void setView(View view, int position) {
      universalAdapter.viewList.set(position, view);
      universalAdapter.notifyItemChanged(position);

  }

  public void initView() {
      RecyclerView recyclerView = new RecyclerView(context);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(context, Width);
      recyclerView.setLayoutManager(gridLayoutManager);

      viewList = new ArrayList<>();
      for (int i = 0; i < Height*Width; i++) {
          View v= (View) createInstance(view, context);

          viewList.add(v);
      }
      universalAdapter = new UniversalAdapter(context, viewList);
      recyclerView.setAdapter(universalAdapter);
      layout.addView(recyclerView);

  } public static <T> T createInstance(Class<T> clazz, Context context) {
        try {
            Constructor<T> constructor = clazz.getConstructor(Context.class);
            return constructor.newInstance(context);
        } catch (Exception e) {

            return null;
        }
    }
    public static class UniversalAdapter extends RecyclerView.Adapter<UniversalAdapter.ViewHolder> {
    private final List<View> viewList;
        private final Context context;

        public UniversalAdapter(Context context, List<View> viewList) {
            this.context = context;
            this.viewList = viewList;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            return new ViewHolder(layout);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.container.removeAllViews();
            holder.container.addView(viewList.get(position));
        }
        @Override
        public int getItemCount() {
            return viewList.size();
        }
        public View getItem(int position) {
            return viewList.get(position);
        }
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final LinearLayout container;

            public ViewHolder(View itemView) {
                super(itemView);
                container = (LinearLayout) itemView;
            }}


}}