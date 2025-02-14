import {TurboModule, TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  initSdk(): Promise<void>;
  startScanDevices(): void;
  pairDevice(deviceMac: string): void;
  disconnectDevice(): void;
  syncAllData(): void;
}

export const NativeCareChainCore = TurboModuleRegistry.getEnforcing<Spec>(
  'NativeCareChainCore',
);

export enum AvailableEvents {
  EVENT_SCAN_STARTED = 'EVENT_SCAN_STARTED',
  EVENT_SCAN_FINISHED = 'EVENT_SCAN_FINISHED',
  EVENT_DEVICE_FOUND = 'EVENT_DEVICE_FOUND',
  EVENT_SCAN_ERROR = 'EVENT_SCAN_ERROR',

  EVENT_PAIR_STATE = 'EVENT_PAIR_STATE',

  EVENT_SYNC_STATUS = 'EVENT_SYNC_STATUS',
}
