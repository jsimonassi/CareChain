import {TurboModule, TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  startScanDevices(): void;
  pairDevice(deviceMac: string): void;
  disconnectDevice(deviceMac: string): void;
  syncAllData(): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>('NativeCareChainCore');
