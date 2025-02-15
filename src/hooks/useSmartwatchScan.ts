/* eslint-disable prettier/prettier */
import { DeviceEventEmitter } from 'react-native';
import { AvailableEvents } from '../specs/NativeCareChainCore';
import { useEffect, useState } from 'react';
import { Smartwatch } from '../types/NativeCareChainCore';

const eventEmitter = DeviceEventEmitter;

export const useSmartwatchScan = () => {
    const [isScanning, setIsScanning] = useState(false);
    const [hasError, setHasError] = useState(false);
    const [devices, setDevices] = useState<Smartwatch[]>([]);

    useEffect(() => {
        const subscription = eventEmitter.addListener(AvailableEvents.EVENT_SCAN_STARTED, _ => {
            setIsScanning(true);
            setHasError(false);
            setDevices([]);
        });

        return () => {
            subscription.remove();
        };
    }, []);

    useEffect(() => {
        const subscription = eventEmitter.addListener(AvailableEvents.EVENT_DEVICE_FOUND, event => {
            if (devices.find(device => device.mac === event.mac)) {
                return;
            }
            setDevices(prev => [...prev, event]);
        });

        return () => {
            subscription.remove();
        };
    }, [devices]);

    useEffect(() => {
        const subscription = eventEmitter.addListener(AvailableEvents.EVENT_SCAN_FINISHED, _ => {
            setIsScanning(false);
        });

        return () => {
            subscription.remove();
        };
    }, [devices]);

    useEffect(() => {
        const subscription = eventEmitter.addListener(AvailableEvents.EVENT_SCAN_ERROR, _ => {
            setHasError(true);
        });

        return () => {
            subscription.remove();
        };
    }, [devices]);

    return {
        isScanning,
        hasError,
        devices,
    };
};
