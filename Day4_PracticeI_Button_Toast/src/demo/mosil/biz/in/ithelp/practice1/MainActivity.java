package demo.mosil.biz.in.ithelp.practice1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int mCount;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* TODO: �ۦ��غc�� */
        //�I��������
        mCount = 0;
        Button btnAttack = (Button)findViewById(R.id.btnAttack);
        btnAttack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: �Q�I����n���檺�ʧ@ */
				//�I���@���N+1
				mCount++;
				//�n�e�{���T���r��
				String msg = "�z�s������F" + mCount + "��";
				Toast.makeText(v.getContext(), msg, Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
