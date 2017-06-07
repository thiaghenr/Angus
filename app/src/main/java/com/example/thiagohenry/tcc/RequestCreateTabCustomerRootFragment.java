//package com.example.thiagohenry.tcc;
//
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//
//import io.realm.internal.Util;
//
//import static com.example.thiagohenry.tcc.R.id.container;
//
///**
// * Created by thiagohenry on 06/06/17.
// */
//
//public class RequestCreateTabCustomerRootFragment extends Fragment {
//
//    private  RequestCreateTabCustomerListFragment       mRequestCreateTabCustomerList;
//    private RequestCreateTabCustomerSelectedFragment    mRequestCreateTabCustomerSelected;
//
//    private FrameLayout                                 tabCustomerList;
//    private FrameLayout                                 tabCustomerSelected;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        final View view1 = inflater.inflate(R.layout.request_create_tab_customer_root, container, false);
//        return view1;
//    }
//
//    public static RequestCreateTabCustomerListFragment newInstance (){
//        RequestCreateTabCustomerListFragment customerFragment = new RequestCreateTabCustomerListFragment();
//        return customerFragment;
//    }
//
//    private void setupProductoExtraFragment(Bundle b){
//        getFragmentManager().beginTransaction().add(R.id.tab_customer_list);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.request_create_tab_customer, mProductoExtraFragment, Util.PRODUCTO_EXTRA).commit();
//
//////        if (b != null) {
////            mRequestCreateTabCustomerList = RequestCreateTabCustomerListFragment.newInstance(b);
////            getSupportFragmentManager().beginTransaction()
////                    .add(R.id.fragment_pizza_config, mProductoExtraFragment, Util.PRODUCTO_EXTRA).commit();
//////        }else{
////            if (mProductoExtraFragment == null) {
////                mProductoExtraFragment = (ProductoExtraFragment) getSupportFragmentManager().findFragmentByTag(Util.PRODUCTO_EXTRA);
////            }
//////        }
//    }
//
//
//
//}
