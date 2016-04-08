package jp.co.future.androidbase.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import jp.co.future.androidbase.R;
import jp.co.future.androidbase.fragment.MainActivityFragment;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnFragmentInteractionListener {

    /** ログ出力用タグ */
    private static final String TAG = MainActivity.class.getSimpleName();

    /** クラス名 */
    private static final String className = MainActivity.class.getName().toString();

    /** バインドするフラグメント */
    private MainActivityFragment fragment;

    /** トランザクションID */
    private static String ikkatuTranId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // フラグメントを生成
            fragment = new MainActivityFragment();
            // フラグメントをアクティビティに追加する FragmentTransaction を利用する
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container, fragment, "fragment");
            transaction.commit();
        }


    }

    @Override
    protected void onResume() {

        super.onResume();
        // フッター部にバージョンの設定
        TextView versionV = (TextView) fragment.getView().findViewById(R.id.txt_version);
        //versionV.setText("Version_" + versionName);


    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 端末の戻るボタンのハンドリングを行う
     *
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // 戻るボタンの無効化
                    return false;

            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onAaClicked(View v) {
        // 画面へ遷移
        // インテントのインスタンス生成
//        Intent intent = new Intent(this, HogeActivity.class);
//        intent.putExtra("mode", CommonKbnConst.VAL_MODE_HAITATU);
//        intent.putExtra("subMode", CommonKbnConst.VAL_MODE_HAITATU);
//        intent.putExtra("clear", true);
        // 次画面のアクティビティ起動
        //startActivity(intent);

    }



    @Override
    public void onSetteiClicked(View v) {
//        // インテントのインスタンス生成
//        Intent intent = new Intent(this, FugaActivity.class);
//        // インテントに値を設定
//        Bundle bundle = new Bundle();
//        bundle.putString("displayMode", "normal");
//        intent.putExtras(bundle);
//        // 次画面のアクティビティ起動
//        startActivity(intent);
    }


}
