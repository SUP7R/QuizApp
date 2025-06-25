package com.QuizApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import com.facebook.shimmer.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HomeActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> m = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private double number = 0;
	private double length = 0;
	private String ban = "";
	private String version = "";
	
	private ArrayList<String> ss = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mm = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear38;
	private LinearLayout linear24;
	private LinearLayout linear3;
	private ImageView imageview9;
	private TextView textview5;
	private TextView textview7;
	private TextView textview6;
	private CircleImageView circleimageview1;
	private LinearLayout linear4;
	private LinearLayout linear_sa;
	private LinearLayout linear15;
	private ListView listview1;
	private LinearLayout linear_shrae;
	private LinearLayout linear_sm;
	private LinearLayout linear5;
	private LinearLayout linear21;
	private ImageView imageview7;
	private RelativeLayout linear9;
	private LinearLayout linear10;
	private ImageView imageview6;
	private TextView textview4;
	private TextView textview2;
	private LinearLayout linear14;
	private LinearLayout linear12;
	private LinearLayout linear19;
	private LinearLayout linear13;
	private ImageView imageview1;
	private EditText edittext1;
	private LinearLayout linear6;
	private RelativeLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear_blak;
	private LinearLayout linear7;
	private ImageView imageview8;
	private ImageView imageview2;
	private LinearLayout linear16;
	private LinearLayout linear25;
	private LinearLayout linear27;
	private ShimmerFrameLayout linear26;
	private LinearLayout linear28;
	private ShimmerFrameLayout linear1;
	private ShimmerFrameLayout linear29;
	private ShimmerFrameLayout linear30;
	private ShimmerFrameLayout linear11;
	private LinearLayout linear23;
	private ShimmerFrameLayout linear31;
	private ShimmerFrameLayout linear32;
	private ShimmerFrameLayout linear8;
	private ShimmerFrameLayout linear33;
	private LinearLayout linear34;
	private ShimmerFrameLayout linear35;
	private ShimmerFrameLayout linear36;
	private ShimmerFrameLayout linear37;
	private ImageView imageview10;
	private TextView textview8;
	private TextView textview9;
	
	private DatabaseReference allquiz = _firebase.getReference("allquiz");
	private ChildEventListener _allquiz_child_listener;
	private Intent i = new Intent();
	private SharedPreferences data;
	private DatabaseReference maintenance = _firebase.getReference("maintenance");
	private ChildEventListener _maintenance_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private DatabaseReference user_app = _firebase.getReference("user_app");
	private ChildEventListener _user_app_child_listener;
	private SharedPreferences ll;
	private TimerTask ti;
	private DatabaseReference update = _firebase.getReference("update");
	private ChildEventListener _update_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview6 = (TextView) findViewById(R.id.textview6);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear_sa = (LinearLayout) findViewById(R.id.linear_sa);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		listview1 = (ListView) findViewById(R.id.listview1);
		linear_shrae = (LinearLayout) findViewById(R.id.linear_shrae);
		linear_sm = (LinearLayout) findViewById(R.id.linear_sm);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		linear9 = (RelativeLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear17 = (RelativeLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear_blak = (LinearLayout) findViewById(R.id.linear_blak);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear26 = (ShimmerFrameLayout) findViewById(R.id.linear26);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		linear1 = (ShimmerFrameLayout) findViewById(R.id.linear1);
		linear29 = (ShimmerFrameLayout) findViewById(R.id.linear29);
		linear30 = (ShimmerFrameLayout) findViewById(R.id.linear30);
		linear11 = (ShimmerFrameLayout) findViewById(R.id.linear11);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear31 = (ShimmerFrameLayout) findViewById(R.id.linear31);
		linear32 = (ShimmerFrameLayout) findViewById(R.id.linear32);
		linear8 = (ShimmerFrameLayout) findViewById(R.id.linear8);
		linear33 = (ShimmerFrameLayout) findViewById(R.id.linear33);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear35 = (ShimmerFrameLayout) findViewById(R.id.linear35);
		linear36 = (ShimmerFrameLayout) findViewById(R.id.linear36);
		linear37 = (ShimmerFrameLayout) findViewById(R.id.linear37);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		ll = getSharedPreferences("ll", Activity.MODE_PRIVATE);
		
		linear_shrae.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(linear_shrae);
				i.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		linear_sm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setClass(getApplicationContext(), UpdateActivity.class);
				startActivity(i);
				_clickAnimation(linear_sm);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				allquiz.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						mm = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								mm.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_charSeq.length() > 0) {
							number = mm.size() - 1;
							length = mm.size();
							for(int _repeat20 = 0; _repeat20 < (int)(length); _repeat20++) {
								if (mm.get((int)number).get("title").toString().toLowerCase().contains(_charSeq.toLowerCase())) {
									
								}
								else {
									mm.remove((int)(number));
								}
								number--;
							}
						}
						listview1.setAdapter(new Listview1Adapter(mm));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_allquiz_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (!data.getString("mydata", "").equals("")) {
					if (_childValue.containsKey("key")) {
						data.edit().remove("mydata").commit();
						data.edit().putString("mydata", new Gson().toJson(mm)).commit();
						ss.add((int)(0), _childKey);
						mm.add((int)0, _childValue);
						listview1.setAdapter(new Listview1Adapter(mm));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				}
				else {
					if (_childValue.containsKey("key")) {
						data.edit().putString("mydata", new Gson().toJson(mm)).commit();
						ss.add((int)(0), _childKey);
						mm.add((int)0, _childValue);
						listview1.setAdapter(new Listview1Adapter(mm));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		allquiz.addChildEventListener(_allquiz_child_listener);
		
		_maintenance_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				i.setClass(getApplicationContext(), MaintenanceActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		maintenance.addChildEventListener(_maintenance_child_listener);
		
		_user_app_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("user_points")) {
						textview5.setText(_childValue.get("user_points").toString());
					}
					if (_childValue.containsKey("user_photo")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("user_photo").toString())).into(circleimageview1);
					}
					if (_childValue.containsKey("ban")) {
						ban = _childValue.get("ban").toString();
					}
					if (_childValue.containsKey("user_name")) {
						textview6.setText(_childValue.get("user_name").toString());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user_app.addChildEventListener(_user_app_child_listener);
		
		_update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("version")) {
					version = _childValue.get("version").toString();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		update.addChildEventListener(_update_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		listview1 = findViewById(R.id.listview1);
		listview1.setOverScrollMode(View.OVER_SCROLL_NEVER);
		
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_ImgRound(imageview1, 45);
		_Add("#FFFFFF", imageview7);
		_Add("#9E9E9E", imageview6);
		linear_sm.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFF5F5F5));
		linear_shrae.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFF6D34F2));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFF5F5F5));
		_ImgRound(imageview8, 50);
		_Add("#FFFFFF", imageview2);
		_Add("#5C27FE", imageview1);
		linear_blak.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFF000000));
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)54, (int)4, 0xFF6D34F2, Color.TRANSPARENT));
		_changeActivityFont("bein");
		if (!data.getString("mydata", "").equals("")) {
			mm = new Gson().fromJson(data.getString("mydata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			allquiz.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					mm = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							mm.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					listview1.setAdapter(new Listview1Adapter(mm));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
		ti = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (ban.equals("true")) {
							linear38.setVisibility(View.VISIBLE);
							linear2.setVisibility(View.GONE);
						}
						else {
							linear38.setVisibility(View.GONE);
							linear2.setVisibility(View.VISIBLE);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(ti, (int)(1000), (int)(1000));
		allquiz.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				mm = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						mm.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				linear15.setVisibility(View.GONE);
				if (version.equals("1.0")) {
					
				}
				else {
					i.setAction(Intent.ACTION_VIEW);
					i.setClass(getApplicationContext(), UpdateActivity.class);
					startActivity(i);
				}
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
		ShimmerFrameLayout container1 = (ShimmerFrameLayout) findViewById(R.id.linear1); container1.startShimmer();
		ShimmerFrameLayout container2 = (ShimmerFrameLayout) findViewById(R.id.linear31); container2.startShimmer();
		ShimmerFrameLayout container3 = (ShimmerFrameLayout) findViewById(R.id.linear35); container3.startShimmer();
		_rippleRoundStroke(linear1, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		_rippleRoundStroke(linear31, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		_rippleRoundStroke(linear35, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		ShimmerFrameLayout container4 = (ShimmerFrameLayout) findViewById(R.id.linear29); container4.startShimmer();
		ShimmerFrameLayout container5 = (ShimmerFrameLayout) findViewById(R.id.linear32); container5.startShimmer();
		ShimmerFrameLayout container6 = (ShimmerFrameLayout) findViewById(R.id.linear36); container6.startShimmer();
		_rippleRoundStroke(linear29, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		_rippleRoundStroke(linear32, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		_rippleRoundStroke(linear36, "#E0E0E0", "#00000000", 15, 0, "#00000000");
		ShimmerFrameLayout container7 = (ShimmerFrameLayout) findViewById(R.id.linear30); container7.startShimmer();
		ShimmerFrameLayout container8 = (ShimmerFrameLayout) findViewById(R.id.linear8); container8.startShimmer();
		ShimmerFrameLayout container9 = (ShimmerFrameLayout) findViewById(R.id.linear37); container9.startShimmer();
		_rippleRoundStroke(linear30, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
		_rippleRoundStroke(linear8, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
		_rippleRoundStroke(linear37, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
		ShimmerFrameLayout container10 = (ShimmerFrameLayout) findViewById(R.id.linear26); container10.startShimmer();
		ShimmerFrameLayout container11 = (ShimmerFrameLayout) findViewById(R.id.linear11); container11.startShimmer();
		ShimmerFrameLayout container12 = (ShimmerFrameLayout) findViewById(R.id.linear33); container12.startShimmer();
		_rippleRoundStroke(linear26, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
		_rippleRoundStroke(linear11, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
		_rippleRoundStroke(linear33, "#E0E0E0", "#00000000", 1000, 0, "#00000000");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _changeActivityFont (final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _Custom_Loading (final boolean _ifShow) {
		if (_ifShow) {
				if (coreprog == null){
						coreprog = new ProgressDialog(this);
						coreprog.setCancelable(false);
						coreprog.setCanceledOnTouchOutside(false);
						
						coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
				}
				coreprog.setMessage(null);
				coreprog.show();
				View _view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
				LinearLayout linear_base = (LinearLayout) _view.findViewById(R.id.linear_base);
				android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
				gd.setColor(Color.parseColor("#FFFFFF"));
				gd.setCornerRadius(100);
				linear_base.setBackground(gd);
				coreprog.setContentView(_view);
		}
		else {
				if (coreprog != null){
						coreprog.dismiss();
				}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _Add (final String _Colour, final ImageView _Imageview) {
		_Imageview.getDrawable().setColorFilter(Color.parseColor(_Colour), PorterDuff.Mode.SRC_IN);
	}
	
	
	public void _ImgRound (final ImageView _imageview, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		gd.setCornerRadius((int)_value);
		_imageview.setClipToOutline(true);
		_imageview.setBackground(gd);
	}
	
	
	public void _clickAnimation (final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _SketchproToast (final String _text) {
		LayoutInflater inflater = getLayoutInflater(); View toastL = inflater.inflate(R.layout.toat, null);
		
		//custom is the name of your custom view
		TextView txt1 = (TextView) toastL.findViewById(R.id.txt1);
		
		LinearLayout lin1 = (LinearLayout) toastL.findViewById(R.id.linear1);
		
		LinearLayout lin2 = (LinearLayout) toastL.findViewById(R.id.linear2);
		
		ImageView imgg1 = (ImageView) toastL.findViewById(R.id.imageview1);
		
		txt1.setText(_text);
		lin1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)22, Color.TRANSPARENT));
		lin2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)22, 0xFF000000));
		txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		Toast toast = new Toast(getApplicationContext()); 
		
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastL);
		toast.show();
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.quiz, null);
			}
			
			final LinearLayout linear = (LinearLayout) _view.findViewById(R.id.linear);
			final LinearLayout linear6 = (LinearLayout) _view.findViewById(R.id.linear6);
			final LinearLayout linear_timer = (LinearLayout) _view.findViewById(R.id.linear_timer);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final LinearLayout linear_sms = (LinearLayout) _view.findViewById(R.id.linear_sms);
			final TextView text_timer = (TextView) _view.findViewById(R.id.text_timer);
			final TextView textviewm = (TextView) _view.findViewById(R.id.textviewm);
			final TextView textview3i = (TextView) _view.findViewById(R.id.textview3i);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			
			linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)54, (int)4, 0xFF6D34F2, Color.TRANSPARENT));
			_ImgRound(imageview2, 50);
			textviewm.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
			textview3i.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
			text_timer.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
			if (_data.get((int)_position).containsKey("title")) {
				textviewm.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("class")) {
				textview3i.setText(_data.get((int)_position).get("class").toString());
			}
			if (_data.get((int)_position).containsKey("Statu")) {
				text_timer.setText(_data.get((int)_position).get("Statu").toString());
			}
			if (_data.get((int)_position).containsKey("image")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(imageview2);
			}
			linear6.setVisibility(View.GONE);
			linear.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (text_timer.getText().toString().equals("متاح الان")) {
						if (_data.get((int)_position).containsKey("key")) {
							i.setClass(getApplicationContext(), QuizdetailActivity.class);
							i.putExtra("keyts", _data.get((int)_position).get("key").toString());
							startActivity(i);
						}
						else {
							_SketchproToast("لم يتم إضافة أي أسئلة حتى الآن");
						}
					}
					else {
						_SketchproToast("الاختبار لا يزال مغلقا حتى الآن");
					}
				}
			});
			if (text_timer.getText().toString().equals("متاح الان")) {
				linear_sms.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF673AB7));
			}
			else {
				linear_sms.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFEEEEEE));
			}
			ObjectAnimator anim = ObjectAnimator.ofFloat(listview1, "Alpha", 0, 1);
			anim.setDuration(500);
			anim.start();
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}