package com.solodroid.ecommerce;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ActivityHome extends Fragment implements OnItemClickListener {
	GridView gridview;
	AdapaterGridView gridviewAdapter;
	ArrayList<GridViewItem> data = new ArrayList<GridViewItem>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_list, container, false);

		gridview = (GridView) v.findViewById(R.id.gridView1);
		gridview.setOnItemClickListener(this);

		data.add(new GridViewItem("All Products", getResources().getDrawable(R.drawable.ic_product)));
		data.add(new GridViewItem("Branches", getResources().getDrawable(R.drawable.ic_info)));
		data.add(new GridViewItem(getResources().getString(R.string.menu_cart), getResources().getDrawable(R.drawable.ic_cart)));
		data.add(new GridViewItem(getResources().getString(R.string.menu_checkout), getResources().getDrawable(R.drawable.ic_checkout)));
		data.add(new GridViewItem("About Me", getResources().getDrawable(R.drawable.ic_profile)));
		data.add(new GridViewItem(getResources().getString(R.string.menu_contact), getResources().getDrawable(R.drawable.ic_contact)));
		data.add(new GridViewItem("G8", getResources().getDrawable(R.drawable.ic_about)));


		setDataAdapter();

		return v;
	}

	// Set the Data Adapter
	private void setDataAdapter() {
		gridviewAdapter = new AdapaterGridView(getActivity(), R.layout.fragment_list_item, data);
		gridview.setAdapter(gridviewAdapter);
	}

	@Override
	public void onItemClick(final AdapterView<?> arg0, final View view, final int position, final long id) {
		if (position==0){
			startActivity(new Intent(getActivity(), ActivityCategoryList.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==1){
			startActivity(new Intent(getActivity(), ActivityCart.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==2){
			startActivity(new Intent(getActivity(), ActivityCheckout.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==3){
			startActivity(new Intent(getActivity(), ActivityProfile.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==4){
			startActivity(new Intent(getActivity(), ActivityInformation.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==5){
			startActivity(new Intent(getActivity(), ActivityAbout.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}
		else if (position==6){
			Intent sendInt = new Intent(Intent.ACTION_SEND);
			sendInt.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
			sendInt.putExtra(Intent.EXTRA_TEXT, "E-Commerce Android App\n\""+getString(R.string.app_name)+"\" \nhttps://play.google.com/store/apps/details?id="+getActivity().getPackageName());
			sendInt.setType("text/plain");
			startActivity(Intent.createChooser(sendInt, "Share"));
		}
		else {
			startActivity(new Intent(getActivity(), ActivityContactUs.class));
			getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
		}

	}

}