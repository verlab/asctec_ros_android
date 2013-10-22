package asctec_hl_comm;

public interface WaypointAction extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "asctec_hl_comm/WaypointAction";
  static final java.lang.String _DEFINITION = "# ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ======\n\nWaypointActionGoal action_goal\nWaypointActionResult action_result\nWaypointActionFeedback action_feedback\n";
  asctec_hl_comm.WaypointActionGoal getActionGoal();
  void setActionGoal(asctec_hl_comm.WaypointActionGoal value);
  asctec_hl_comm.WaypointActionResult getActionResult();
  void setActionResult(asctec_hl_comm.WaypointActionResult value);
  asctec_hl_comm.WaypointActionFeedback getActionFeedback();
  void setActionFeedback(asctec_hl_comm.WaypointActionFeedback value);
}