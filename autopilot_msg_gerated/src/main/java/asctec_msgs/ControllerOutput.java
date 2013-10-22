package asctec_msgs;

public interface ControllerOutput extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_msgs/ControllerOutput";
  static final java.lang.String _DEFINITION = "# Software License Agreement (BSD License)\n#\n# Copyright (c) 2010\n#  William Morris <morris@ee.ccny.cuny.edu>\n#  Ivan Dryanovski <ivan.dryanovski@gmail.com>\n# All rights reserved.\n#\n# Redistribution and use in source and binary forms, with or without\n# modification, are permitted provided that the following conditions\n# are met:\n#\n#  * Redistributions of source code must retain the above copyright\n#    notice, this list of conditions and the following disclaimer.\n#  * Redistributions in binary form must reproduce the above\n#    copyright notice, this list of conditions and the following\n#    disclaimer in the documentation and/or other materials provided\n#    with the distribution.\n#  * Neither the name of CCNY Robotics Lab nor the names of its\n#    contributors may be used to endorse or promote products derived\n#    from this software without specific prior written permission.\n#\n# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS\n# \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT\n# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS\n# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE\n# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,\n# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,\n# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER\n# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN\n# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE\n# POSSIBILITY OF SUCH DAMAGE.\n\nHeader header\n#attitude controller outputs; 0..200 = -100 .. +100 %\nint32 nick\nint32 roll\nint32 yaw\n\n#current thrust (height controller output); 0..200 = 0..100%\nint32 thrust\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  int getNick();
  void setNick(int value);
  int getRoll();
  void setRoll(int value);
  int getYaw();
  void setYaw(int value);
  int getThrust();
  void setThrust(int value);
}
