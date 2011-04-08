/*
 * GT-Mconf: Multiconference system for interoperable web and mobile
 * http://www.inf.ufrgs.br/prav/gtmconf
 * PRAV Labs - UFRGS
 * 
 * This file is part of Mconf-Mobile.
 *
 * Mconf-Mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Mconf-Mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Mconf-Mobile.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mconf.bbb.android.video;

import org.mconf.bbb.android.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public class VideoDialog extends Dialog {	
	private static final Logger log = LoggerFactory.getLogger(VideoDialog.class);
	private VideoSurface videoWindow;
	
	public VideoDialog(Context context, int userId) {
		super(context);
		
		setContentView(R.layout.video_window);
		
		android.view.WindowManager.LayoutParams windowAttributes = getWindow().getAttributes();
//		windowAttributes.screenBrightness = 1;
	    windowAttributes.flags = android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		getWindow().setAttributes(windowAttributes);
		
		videoWindow = (VideoSurface) findViewById(R.id.video_window);
		LayoutParams layoutParams = videoWindow.getLayoutParams();
		layoutParams.height = 240;
		layoutParams.width = 320;				
		videoWindow.setLayoutParams(layoutParams);
		videoWindow.start(userId, 320, 240);

		setTitle("Video");
		setCancelable(true);
	}
	
	@Override
	protected void onStop() {
		
		// TODO Auto-generated method stub
		super.onStop();

		videoWindow.onPause();
	}
}
