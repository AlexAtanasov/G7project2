
package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.swedspot.automotiveapi.AutomotiveSignal;
import android.swedspot.automotiveapi.AutomotiveSignalId;
import android.swedspot.scs.data.SCSFloat;
import android.text.Selection;
import android.widget.TextView;

import com.swedspot.automotiveapi.AutomotiveFactory;
import com.swedspot.automotiveapi.AutomotiveListener;
import com.swedspot.vil.distraction.DriverDistraction;
import com.swedspot.vil.distraction.DriverDistractionLevel;
import com.swedspot.vil.distraction.DriverDistractionListener;
import com.swedspot.vil.distraction.LightMode;
import com.swedspot.vil.distraction.StealthMode;
import com.swedspot.vil.policy.AutomotiveCertificate;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.Object;
import java.lang.Override;
import java.lang.Runnable;
import java.lang.String;



/**
 * Created by Viktor on 2015-04-24.
 */
public class AgaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_aga, container, false);

        final TextView ds = (TextView) view.findViewById(R.id.displaySpeed);

        AsyncTask async = new AsyncTask() {

            protected Object doInBackground(Object[] params) {
                AutomotiveFactory.createAutomotiveManagerInstance(
                        new AutomotiveCertificate(new byte[0]),
                        new AutomotiveListener() {
                            @Override
                            public void receive(final AutomotiveSignal automotiveSignal) {
                                if (automotiveSignal.getSignalId() == AutomotiveSignalId.FMS_WHEEL_BASED_SPEED) {
                                    ds.post(new Runnable() { // Post the result back to the View/UI thread

                                        public void run() {
                                            ds.setText(String.format("%.1f km/h", ((SCSFloat) automotiveSignal.getData()).getFloatValue()));
                                        }
                                    });
                                }
                        }
                @Override
                            public void timeout(int i) {
                            }

                            @Override
                            public void notAllowed(int i) {
                            }
                        },

                        new DriverDistractionListener() { // Observe driver distraction level
                            @Override
                            public void levelChanged(final DriverDistractionLevel driverDistractionLevel) {
                                ds.post(new Runnable() { // Post the result back to the View/UI thread
                                    public void run() {
                                        Intent i = new Intent(AgaFragment.this.getActivity(), StartMenuAct.class);
                                        Bundle b = new Bundle();
                                        b.putInt("Distraction", driverDistractionLevel.getLevel());
                                        i.putExtras(b);
                                        startActivity(i);
                                    }
                                });
                            }

                            @Override
                            public void lightModeChanged(LightMode lightMode) {

                            }

                            @Override
                            public void stealthModeChanged(StealthMode stealthMode) {

                            }
                        }
                ).register(AutomotiveSignalId.FMS_WHEEL_BASED_SPEED);
                return null;
            }};
        async.execute();
        return view;
    }

}

