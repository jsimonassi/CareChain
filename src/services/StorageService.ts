import AsyncStorage from '@react-native-async-storage/async-storage';

export const StorageService = {
  setItem: async (key: string, value: string) => {
    try {
      await AsyncStorage.setItem(key, value);
    } catch (error) {
      console.log(error);
    }
  },
  getItem: async (key: string) => {
    try {
      const value = await AsyncStorage.getItem(key);
      if (value !== null) {
        return value;
      }
    } catch (error) {
      console.log(error);
    }
  },
  removeItem: async (key: string) => {
    try {
      await AsyncStorage.removeItem(key);
    } catch (error) {
      console.log(error);
    }
  },
  clear: async () => {
    try {
      await AsyncStorage.clear();
    } catch (error) {
      console.log(error);
    }
  },
};
