package asctec_msgs;

public interface RCData extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_msgs/RCData";
  static final java.lang.String _DEFINITION = "# Software License Agreement (BSD License)\n#\n# Copyright (c) 2010\n#  William Morris <morris@ee.ccny.cuny.edu>\n#  Ivan Dryanovski <ivan.dryanovski@gmail.com>\n# All rights reserved.\n#\n# Redistribution and use in source and binary forms, with or without\n# modification, are permitted provided that the following conditions\n# are met:\n#\n#  * Redistributions of source code must retain the above copyright\n#    notice, this list of conditions and the following disclaimer.\n#  * Redistributions in binary form must reproduce the above\n#    copyright notice, this list of conditions and the following\n#    disclaimer in the documentation and/or other materials provided\n#    with the distribution.\n#  * Neither the name of CCNY Robotics Lab nor the names of its\n#    contributors may be used to endorse or promote products derived\n#    from this software without specific prior written permission.\n#\n# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS\n# \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT\n# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS\n# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE\n# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,\n# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,\n# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER\n# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN\n# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE\n# POSSIBILITY OF SUCH DAMAGE.\n\n#    struct RC_DATA\n#    {\n#      //channels as read from R/C receiver\n#      unsigned short channels_in[8];\n#      //channels bias free, remapped and scaled to 0..4095\n#      unsigned short channels_out[8];\n#     //Indicator for valid R/C receiption\n#      unsigned char lock;\n#    };\nHeader header\n# channels as read from R/C receiver\nint16[8] channels_in\n\n#channels bias free, remapped and scaled to 0..4095\nint16[8] channels_out\n\n#indicator for valid R/C receiption\nint16 lock\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  short[] getChannelsIn();
  void setChannelsIn(short[] value);
  short[] getChannelsOut();
  void setChannelsOut(short[] value);
  short getLock();
  void setLock(short value);
}
