package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		this.channel = channel % 256;
		
		if (channel == 0 && this.channel == 0) {
			this.channel = 255;
		} else if (channel != 0 && this.channel == 0) {
			this.channel = 1;
		}
	}
	
	public void channel(boolean up) {
		if (up) {
			this.channel++;
			this.channel = this.channel % 256;
			
			if (this.channel == 0) {
				this.channel = 1;
			}
		} else {
			this.channel--;
			this.channel = this.channel % 256;
			
			if (this.channel == 0) {
				this.channel = 255;
			}
		}
		
	}
	
	public void volume(int volume) {
		if ((this.volume + volume) > 100) {
			this.volume = 0;
		} else {
			this.volume += volume;
		}
	}
	
	public void volume(boolean up) {
		if (up) {
			this.volume++;
			if (this.volume > 100) {
				this.volume = 0;
			}
		} else {
			this.volume--;
			if (this.volume < 0) {
				this.volume = 100;
			}
		}
	}
	
	public void status() {
		System.out.println("TV[channel = " + channel + ", volume = " + volume + ", power = " + power + "]");
	}
}
