package com.example.dave.statemachineactivity;

import android.app.Activity;
import android.content.Intent;
import com.example.dave.statemachineactivity.MainActivity;
import com.example.dave.statemachineactivity.MainActivity2;
import com.example.dave.statemachineactivity.MainActivity3;
import com.example.dave.statemachineactivity.MainActivity4;

/**
 * Created by Dave on 11/13/2014.
 */
public class StateMachine {

    static Thread welcomeThread;
    static Boolean threadEnabled = true;

    public static void InitThread()
    {
        welcomeThread = new Thread() {
            @Override
            public void run() {

                while (threadEnabled) {
                    try {
                        sleep(2500);
                        if (threadEnabled) {
                            GlobalStateMachine();
                        }
                    }
                    catch (InterruptedException e) {
                    }
                    finally {
                    }
                }
            }
        };
        welcomeThread.start();
    }

    static Activity mActivity;
    public static void SetCurrentActivity (Activity activity)
    {
        mActivity = activity;
    }

    public static void KillThread ()
    {
        threadEnabled = false;
    }

    private static int state = 0;
    private static void GlobalStateMachine() {

        // Uses the activity instance
        state++;

        if (state > 5)
        {
            state = 0;
        }

        switch (state)
        {
            case 1:
                mActivity.startActivity(new Intent(mActivity, MainActivity2.class));
                break;

            case 3:
                mActivity.startActivity(new Intent(mActivity, MainActivity3.class));
                break;

            case 5:
                mActivity.startActivity(new Intent(mActivity, MainActivity4.class));
                break;

            default:
                mActivity.finish();
                break;

        }


    }

}
