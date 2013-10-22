package asctec_msgs;

public interface IMURawData extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_msgs/IMURawData";
  static final java.lang.String _DEFINITION = "# Software License Agreement (BSD License)\n#\n# Copyright (c) 2010\n#  William Morris <morris@ee.ccny.cuny.edu>\n#  Ivan Dryanovski <ivan.dryanovski@gmail.com>\n# All rights reserved.\n#\n# Redistribution and use in source and binary forms, with or without\n# modification, are permitted provided that the following conditions\n# are met:\n#\n#  * Redistributions of source code must retain the above copyright\n#    notice, this list of conditions and the following disclaimer.\n#  * Redistributions in binary form must reproduce the above\n#    copyright notice, this list of conditions and the following\n#    disclaimer in the documentation and/or other materials provided\n#    with the distribution.\n#  * Neither the name of CCNY Robotics Lab nor the names of its\n#    contributors may be used to endorse or promote products derived\n#    from this software without specific prior written permission.\n#\n# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS\n# \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT\n# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS\n# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE\n# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,\n# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,\n# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER\n# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN\n# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE\n# POSSIBILITY OF SUCH DAMAGE.\n\nHeader header\n#pressure sensor 24-bit value, not scaled but bias free\nint32 pressure\n\n#16-bit gyro readings; 32768 = 2.5V\nint16 gyro_x\nint16 gyro_y\nint16 gyro_z\n\n#10-bit magnetic field sensor readings\nint16 mag_x\nint16 mag_y\nint16 mag_z\n\n#16-bit accelerometer readings\nint16 acc_x\nint16 acc_y\nint16 acc_z\n\n#16-bit temperature measurement using yaw-gyro internal sensor\nint16 temp_gyro\n\n#16-bit temperature measurement using ADC internal sensor\nint32 temp_ADC\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  int getPressure();
  void setPressure(int value);
  short getGyroX();
  void setGyroX(short value);
  short getGyroY();
  void setGyroY(short value);
  short getGyroZ();
  void setGyroZ(short value);
  short getMagX();
  void setMagX(short value);
  short getMagY();
  void setMagY(short value);
  short getMagZ();
  void setMagZ(short value);
  short getAccX();
  void setAccX(short value);
  short getAccY();
  void setAccY(short value);
  short getAccZ();
  void setAccZ(short value);
  short getTempGyro();
  void setTempGyro(short value);
  int getTempADC();
  void setTempADC(int value);
}
