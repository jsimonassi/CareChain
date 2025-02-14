import {NativeCareChainCore} from '../specs/NativeCareChainCore';

export const WatchService = {
  initSdk: NativeCareChainCore.initSdk,
  startScanDevices: NativeCareChainCore.startScanDevices,
  pairDevice: NativeCareChainCore.pairDevice,
  disconnectDevice: NativeCareChainCore.disconnectDevice,
  syncAllData: NativeCareChainCore.syncAllData,
};
