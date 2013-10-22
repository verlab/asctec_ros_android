package asctec_msgs;

public interface CtrlInput extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_msgs/CtrlInput";
  static final java.lang.String _DEFINITION = "# Software License Agreement (BSD License)\n#\n# Copyright (c) 2010\n#  William Morris <morris@ee.ccny.cuny.edu>\n#  Ivan Dryanovski <ivan.dryanovski@gmail.com>\n# All rights reserved.\n#\n# Redistribution and use in source and binary forms, with or without\n# modification, are permitted provided that the following conditions\n# are met:\n#\n#  * Redistributions of source code must retain the above copyright\n#    notice, this list of conditions and the following disclaimer.\n#  * Redistributions in binary form must reproduce the above\n#    copyright notice, this list of conditions and the following\n#    disclaimer in the documentation and/or other materials provided\n#    with the distribution.\n#  * Neither the name of CCNY Robotics Lab nor the names of its\n#    contributors may be used to endorse or promote products derived\n#    from this software without specific prior written permission.\n#\n# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS\n# \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT\n# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS\n# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE\n# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,\n# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,\n# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER\n# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN\n# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE\n# POSSIBILITY OF SUCH DAMAGE.\n\nHeader header\n# serial command (=Scientific Interface)\n# Pitch input: -2047 .. 2047 (0 = neutral)\nint16 pitch\n# Roll input: -2047 .. 2047 (0 = neutral)\nint16 roll\n# R/C Stick input: -2047 .. 2047 (0 = neutral)\nint16 yaw\n# Collective: 0 .. 4095 (= 0 .. 100%)\nint16 thrust\n# control byte:\n#    bit 0: pitch control enabled\n#    bit 1: roll control enabled\n#    bit 2: yaw control enabled\n#    bit 3: thrust control enabled\n#  These bits can be used to only enable one axis at a time and thus to control\n#  the other axes manually. This usually helps a lot to set up and finetune\n#  controllers for each axis seperately.\nint16 ctrl\nint16 chksum\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  short getPitch();
  void setPitch(short value);
  short getRoll();
  void setRoll(short value);
  short getYaw();
  void setYaw(short value);
  short getThrust();
  void setThrust(short value);
  short getCtrl();
  void setCtrl(short value);
  short getChksum();
  void setChksum(short value);
}
