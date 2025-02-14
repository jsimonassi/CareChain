export interface Smartwatch {
  name: string;
  mac: string;
}

export enum PairState {
  PAIR_STATE_CONNECTED = 1,
  PAIR_STATE_DISCONNECTED = 2,
  PAIR_STATE_CONNECTING = 3,
}

export enum SyncState {
  SYNC_STATUS_IN_PROGRESS = 0,
  SYNC_STATUS_FINISHED = 1,
}

export interface SyncStateEvent {
  status: SyncState;
  progress: number;
}

export interface PairStateEvent {
  state: PairState;
}
