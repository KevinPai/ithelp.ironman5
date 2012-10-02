package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Moogle1Activity extends Activity {
	private Button mBtnCallMoogle2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle1);
        mBtnCallMoogle2 = (Button)findViewById(R.id.btn_call_moogle2);
        mBtnCallMoogle2.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v) {
    			/* TODO: �Q�I����n���檺�ʧ@ */
    			Intent intent = new Intent(Moogle1Activity.this, Moogle2Activity.class);
    			//�üƨ��@��0~10���ƭ�
    			int signal = (int)(Math.random()*10) + 1;
    			Bundle bundle = new Bundle();
    			//����r(key)��"Signal"�A�ȬO�üƲ��ͪ��@���H����
    			bundle.putInt("Signal", signal);
    			intent.putExtras(bundle);
    			startActivity(intent);
    		}
        });
    }

    @Override
	protected void onStart() {
		super.onStart();
		final String message;
		int signal;
		
		try{
			//���o Moogle2 �ǨӪ��]�q
			Bundle bundleFromMoogle2 = getIntent().getExtras();
			if(bundleFromMoogle2 != null){
				//��Ķ Moogle2 �ǨӪ��T��
				signal = (bundleFromMoogle2.containsKey("Signal"))? 
						bundleFromMoogle2.getInt("Signal") : -1;
				if(signal == -1){
					message = "��X�����D���a���A�A���Ǥ@���a�I";
				} else {
					message = (bundleFromMoogle2.containsKey("Message")) ? 
							bundleFromMoogle2.getString("Message") : "�^���L�Q����I";
				}
				
			    
			    //��l�ƪ���
		        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		    	//�]�w���D
		        dialog.setTitle("�^�Ъ����e ");
				//�]�w���e
		        dialog.setMessage(message);
		        //�]�w�ϥ�
		    	dialog.setIcon(android.R.drawable.ic_dialog_alert);
		    	//���T(�|)�Ѥ��䪺��^�\�ॢ��
		    	dialog.setCancelable(false);
		    	dialog.setPositiveButton("����", new DialogInterface.OnClickListener() {
		    		public void onClick(DialogInterface dialog, int which) {
		    			//�ΦR�q(Toast)�ӶǥX�T��
					    Toast.makeText(Moogle1Activity.this, message, Toast.LENGTH_LONG).show();
					}
					
				});
		    	dialog.setNegativeButton("�L��", new DialogInterface.OnClickListener() {
		    		public void onClick(DialogInterface dialog, int which) {
		    			
					}
					
				});
		        dialog.show();
			}
		} catch(Exception ex){
			
		}
		
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle1, menu);
        return true;
    }
}
