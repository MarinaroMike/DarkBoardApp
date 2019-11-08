package com.example.platypie_darkboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.platypie_darkboard.databinding.FragmentMainBinding;
import com.example.platypie_darkboard.databinding.ListItemCourseCardBinding;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*  Basic activity which hosts UIFragment

    Michael Marinaro November 2019
 */

public class UIFragment extends Fragment {

    private Manager manager;
    private CourseRepository repository = CourseRepository.getInstance();


    public static UIFragment newInstance() {
        return new UIFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        manager = new Manager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //populate view from list of courses
        binding.recyclerView.setAdapter(new CourseAdapter(repository.getCourseList()));

        return binding.getRoot();
    }

    private class CourseHolder extends RecyclerView.ViewHolder {
        private ListItemCourseCardBinding mBinding;

        private CourseHolder(ListItemCourseCardBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new ViewModel(manager));
        }

        public void bind(Course course) {
            mBinding.getViewModel().setCourse(course);
            mBinding.executePendingBindings();
        }
    }

    private class CourseAdapter extends RecyclerView.Adapter<CourseHolder> {
        private List<Course> mCourses;

        public CourseAdapter(List<Course> courses){
            mCourses = courses;
        }



        @Override
        public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemCourseCardBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_course_card, parent, false);
            return new CourseHolder(binding);
        }

        @Override
        public void onBindViewHolder(CourseHolder holder, int position) {
            Course course = mCourses.get(position);
            holder.bind(course);

        }

        @Override
        public int getItemCount() {
            return mCourses.size();
        }
    }
}
