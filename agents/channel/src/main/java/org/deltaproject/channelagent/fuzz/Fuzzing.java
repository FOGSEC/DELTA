package org.deltaproject.channelagent.fuzz;

public class Fuzzing {
	public enum PACKET_IN {
		buffer_id(4), total_len(2), in_port(2), reason(1), pad(1), data(-1);

		private int byteLen;
		private int startOffset;

		PACKET_IN(int num) {
			byteLen = num;

			if (this.name().equals("buffer_id")) {
				startOffset = 8;
			} else if (this.name().equals("total_len")) {
				startOffset = 12;
			} else if (this.name().equals("in_port")) {
				startOffset = 14;
			} else if (this.name().equals("reason")) {
				startOffset = 16;
			} else if (this.name().equals("pad")) {
				startOffset = 17;
			} else if (this.name().equals("data")) {
				startOffset = 18;
			}
		}

		public int getLen() {
			return byteLen;
		}

		public int getStartOff() {
			return startOffset;
		}
	}
}