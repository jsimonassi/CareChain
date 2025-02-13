import {create} from 'zustand';
import {StorageService} from '../../services/StorageService';

const cacheKeys = {
  walletAddress: 'useMetamaskStore-walletAddress',
};

interface MetamaskStore {
  walletAddress: string | null;
  balance: number;
  loadDataFromCache: () => void;
  setWalletAddress: (address: string | null) => void;
  setBalance: (balance: number) => void;
  reset: () => void;
}

export const useMetamaskStore = create<MetamaskStore>(set => ({
  walletAddress: null,
  balance: 0,
  loadDataFromCache: async () => {
    const walletAddress = await StorageService.getItem(cacheKeys.walletAddress);
    set({walletAddress});
  },
  setWalletAddress: address => {
    StorageService.setItem(cacheKeys.walletAddress, address || '');
    set({walletAddress: address});
  },
  setBalance: balance => set({balance}),
  reset: () => set({walletAddress: null, balance: 0}),
}));
