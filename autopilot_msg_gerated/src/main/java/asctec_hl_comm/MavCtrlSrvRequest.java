package asctec_hl_comm;

public interface MavCtrlSrvRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_hl_comm/MavCtrlSrvRequest";
  static final java.lang.String _DEFINITION = "mav_ctrl ctrl\n";
  asctec_hl_comm.mav_ctrl getCtrl();
  void setCtrl(asctec_hl_comm.mav_ctrl value);
}
