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
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.content.ClipData;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.bumptech.glide.Glide;
import android.graphics.Typeface;
import com.facebook.shimmer.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ProfileActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_PNG = 101;
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private boolean click = false;
	private String avatarPath = "";
	private String AvatarName = "";
	private double no = 0;
	
	private ArrayList<String> ss = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear1;
	private ImageView imageview2;
	private LinearLayout linear3;
	private ImageView imageview3;
	private LinearLayout linear9;
	private TextView textview3;
	private TextView textview2;
	private EditText edittext1;
	private Button buy;
	private LinearLayout linear15;
	private ListView listview3;
	private ImageView imageview1;
	private LinearLayout linear16;
	private TextView textview6;
	private TextView textview5;
	private LinearLayout linear17;
	private TextView textview4;
	
	private DatabaseReference user_app = _firebase.getReference("user_app");
	private ChildEventListener _user_app_child_listener;
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
	private Intent png = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference fs = _firebase_storage.getReference("fs");
	private OnCompleteListener<Uri> _fs_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _fs_download_success_listener;
	private OnSuccessListener _fs_delete_success_listener;
	private OnProgressListener _fs_upload_progress_listener;
	private OnProgressListener _fs_download_progress_listener;
	private OnFailureListener _fs_failure_listener;
	private SharedPreferences di_rank;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		buy = (Button) findViewById(R.id.buy);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		listview3 = (ListView) findViewById(R.id.listview3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		textview4 = (TextView) findViewById(R.id.textview4);
		auth = FirebaseAuth.getInstance();
		png.setType("image/*");
		png.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		di_rank = getSharedPreferences("di_rank", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		buy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (click) {
					click = false;
					if (edittext1.getText().toString().equals("")) {
						_clickAnimation(buy);
						edittext1.setVisibility(View.GONE);
						_SketchproToast("الاسم فارغ ولم يتمكن من تعديله");
					}
					else {
						_clickAnimation(buy);
						edittext1.setVisibility(View.GONE);
						_SketchproToast("تم تغير الاسم");
						map = new HashMap<>();
						map.put("user_name", edittext1.getText().toString());
						user_app.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						listview3.setAdapter(new Listview3Adapter(mm));
						((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
					}
				}
				else {
					click = true;
					_clickAnimation(buy);
					edittext1.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(png, REQ_CD_PNG);
			}
		});
		
		_user_app_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ss.add(_childKey);
				mm.add(_childValue);
				SketchwareUtil.sortListMap(mm, "user_points", true, false);
				listview3.setAdapter(new Listview3Adapter(mm));
				((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textview3.setText("الاسم".concat(" ".concat(" ".concat(":".concat(" ".concat(" ".concat(_childValue.get("user_name").toString())))))));
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("user_photo").toString())).into(imageview1);
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
		
		_fs_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				SketchwareUtil.showMessage(getApplicationContext(), String.valueOf((long)(_progressValue)).concat("%"));
			}
		};
		
		_fs_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_fs_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				fs.child(AvatarName).putFile(Uri.fromFile(new File(avatarPath))).addOnFailureListener(_fs_failure_listener).addOnProgressListener(_fs_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return fs.child(AvatarName).getDownloadUrl();
					}}).addOnCompleteListener(_fs_upload_success_listener);
				map = new HashMap<>();
				map.put("user_photo", _downloadUrl);
				user_app.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
				map.clear();
			}
		};
		
		_fs_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_fs_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_fs_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), "failed to upload photo , the cause is : ".concat(_message));
			}
		};
		
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		edittext1.setVisibility(View.GONE);
		listview3 = findViewById(R.id.listview3);
		listview3.setOverScrollMode(View.OVER_SCROLL_NEVER);
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)54, (int)4, 0xFF6D34F2, Color.TRANSPARENT));
		textview2.setText("الايميل الخاص بك".concat(" ".concat(" ".concat(":".concat(" ".concat(" ".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail())))))));
		_changeActivityFont("bein");
		_ImgRound(imageview1, 50);
		_Custom_Loading(true);
		user_app.addListenerForSingleValueEvent(new ValueEventListener() {
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
				_Custom_Loading(false);
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PNG:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				avatarPath = _filePath.get((int)(0));
				if (avatarPath.endsWith(".png")) {
					AvatarName = user_app.push().getKey().concat(".png");
					imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(avatarPath, 1024, 1024));
				}
				else {
					if (avatarPath.endsWith(".jpg")) {
						AvatarName = user_app.push().getKey().concat(".jpg");
						imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(avatarPath, 1024, 1024));
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "This file type is not supported.");
					}
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
		int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
		int clrs [] = {0xFF673AB7,0xFF5C27FE};
		SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, clrs);
		SketchUi.setCornerRadii(new float[]{
			d*100,d*100,d*100 ,d*100,d*100,d*100 ,d*100,d*100});
		android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF6200EA}), SketchUi, null);
		buy.setBackground(SketchUiRD);
		buy.setClickable(true);
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
	
	
	public void _ImgRound (final ImageView _imageview, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		gd.setCornerRadius((int)_value);
		_imageview.setClipToOutline(true);
		_imageview.setBackground(gd);
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
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public class Listview3Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.user, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear11 = (LinearLayout) _view.findViewById(R.id.linear11);
			final LinearLayout linear9 = (LinearLayout) _view.findViewById(R.id.linear9);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview1 = (de.hdodenhof.circleimageview.CircleImageView) _view.findViewById(R.id.circleimageview1);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			
			if (_data.get((int)_position).containsKey("user_name")) {
				textview2.setText(_data.get((int)_position).get("user_name").toString());
			}
			if (_data.get((int)_position).containsKey("user_points")) {
				textview1.setText(_data.get((int)_position).get("user_points").toString());
			}
			if (_data.get((int)_position).containsKey("user_photo")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("user_photo").toString())).into(circleimageview1);
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fortenh.ttf"), 0);
			if (_position == 0) {
				_rippleRoundStroke(linear11, "#FFC801", "#FFFFFF", 15, 0, "#B0B0B8");
				textview3.setTextColor(0xFFFFFFFF);
			}
			else {
				if (_position == 1) {
					_rippleRoundStroke(linear11, "#B0B0B8", "#FFFFFF", 15, 0, "#B0B0B8");
					textview3.setTextColor(0xFFFFFFFF);
				}
				else {
					if (_position == 2) {
						_rippleRoundStroke(linear11, "#A78967", "#FFFFFF", 15, 0, "#B0B0B8");
						textview3.setTextColor(0xFFFFFFFF);
					}
					else {
						_rippleRoundStroke(linear11, "#FFFFFF", "#FFFFFF", 15, 0, "#B0B0B8");
					}
				}
			}
			if (_position == _position) {
				textview3.setText("#".concat(String.valueOf((long)(Double.parseDouble(String.valueOf((long)(_position))) + 1))));
			}
			
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